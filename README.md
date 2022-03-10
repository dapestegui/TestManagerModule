# TestManagerModule

Business case for Diego Apestegui 

Test Manager Module is in charge of executing Operations on top of Laboratories Test. Each test can have multiple operations executed and each operation can have specific behavior depending on the test type.

This is a project structured for the Test Manager Module focused on the operations facet. Control  and reporting over the tests and results are not considered on this design. 

# UML Diagram


![TestCase2](https://user-images.githubusercontent.com/32935258/157770079-0838c3fa-90df-450d-b326-cf8ec93a3db1.png)


# Refactoring strategy

Considering the original Test Manager Module is a monolith that uses a procedural style to manage each operation and a hexagonal microservices architecture is desired, the following refactoring strategy is proposed. 

1. **Define each domain:** Each domain needs to be correctly defined from a abstract perspective, in this case we know Operation, Sample, Test and Order are high level domains and should be treated as such.

2. **Reorganize the code in modules per service:** Current code should be reorganized in modules such that each module only encompasses a single service. This will enable easier decoupling in the next phases and easier maintenance.
Depending on the size of the domain each one of them could be service or multiple domains could exist under the same service/module. 

3. **Split the databases:** Following the same philosophy as the previous step, the databases should be split so that each service has a dedicated database to depend upon.

4. **Define and implement a unified API Gateway:** If following the API first philosophy we should define a unified API that can work as a facade between our external dependencies and our new and old services, this will be crucial to ensure
consistency, resilience and robustness going forward. The ultimate goal is for the external services to be oblivious of any changes on our side and for us to have a way of building and testing the new code in a safe and efficient manner. 
The big unknown is how expensive in time and effort this middleware application will be, if facading between old REST and new REST (less complicated), or if other mechanisms/protocols are involved(more complicated), the standarization effort is going to be significant.

5. **Start building the new stand alone services:** Once the API definition is in place the creation of the new service can start. The API gateway and the new services can be developed in parallel as long as the API that interconnects them is properly defined.

6. **Migrate services:** Start by testing small and trivial transactions, using the API gateway to switch between the new and old services on a endpoint and/or traffic basis (A/B testing, feature switching, canary deployment). 
Enabling new endpoints with little traffic first and then increasing the load while making sure the system behaves as expected and the auditing is correct. 

7. **Decomission the old services:** Once the new services have proven to be reliable and correct the old systems can be decomissioned. 


# Project structure and design patterns

The project is structured following a Domain Driven Desing approach (the top division is each domain) and below each one of them a hexagonal architecture. 

The domain folder has all the core models and the inbound and outbound ports.

The application folder has the implemented use cases with the business rules for the ports.

The infraestructure folder (some controllers are omitted for simplicity) would have the all the adapters necessary to communicate with the external systems (REST controllers, Databases, etc). 

The core entity is Operation, which is an interface (facade) from which all Operations inherit. This enables a uniform behavior thoughout the system.

LaboratoryTest is an interface with a very basic structure, upon which a few abstract classes were created to group based on a common behavior (i.e. Biochemistry category has a abstract class). 

Finally to get the correct Operation based on the laboratory test type and the operation type we have a factory that will provide us with the correct implementation for such parameters.
