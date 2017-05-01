package base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ArrayList<PersonDomainModel> person = PersonDAL.getPersons();
		for(PersonDomainModel per : person) {
			PersonDAL.deletePerson(per.getPersonID());
		}
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		/* add   person*/
		PersonDomainModel personDomainModel = new PersonDomainModel();
		personDomainModel.setPersonID(UUID.randomUUID());
		personDomainModel.setFirstName("Hans");
		personDomainModel.setLastName("Muster");
		personDomainModel.setCity("some city");
		personDomainModel.setStreet("some street");
		personDomainModel.setPostalCode(1234);
		personDomainModel.setBirthday(LocalDate.of(1999, 2, 21));
		PersonDAL.addPerson(personDomainModel);
		personDomainModel = new PersonDomainModel();
		personDomainModel.setPersonID(UUID.randomUUID());
		personDomainModel.setFirstName("Ruth");
		personDomainModel.setLastName("Muster");
		personDomainModel.setCity("some city");
		personDomainModel.setStreet("some street");
		personDomainModel.setPostalCode(1234);
		personDomainModel.setBirthday(LocalDate.of(1999, 2, 21));
		PersonDAL.addPerson(personDomainModel);
		personDomainModel = new PersonDomainModel();
		personDomainModel.setPersonID(UUID.randomUUID());
		personDomainModel.setFirstName("Heinz");
		personDomainModel.setLastName("Kurz");
		personDomainModel.setCity("some city");
		personDomainModel.setStreet("some street");
		personDomainModel.setPostalCode(1234);
		personDomainModel.setBirthday(LocalDate.of(1999, 2, 21));
		PersonDAL.addPerson(personDomainModel);
		personDomainModel = new PersonDomainModel();
		personDomainModel.setPersonID(UUID.randomUUID());
		personDomainModel.setFirstName("Cornelia");
		personDomainModel.setLastName("Meier");
		personDomainModel.setCity("some city");
		personDomainModel.setStreet("some street");
		personDomainModel.setPostalCode(1234);
		personDomainModel.setBirthday(LocalDate.of(1999, 2, 21));
		PersonDAL.addPerson(personDomainModel);
		
		/* get persons */
		PersonDAL.getPersons();
		
		/* get person */
		PersonDAL.getPerson(PersonDAL.getPersons().get(0).getPersonID());
		
		/* update person */
		personDomainModel = new PersonDomainModel();
		personDomainModel.setPersonID(PersonDAL.getPersons().get(0).getPersonID());
		personDomainModel.setFirstName("Werner");
		PersonDAL.updatePerson(personDomainModel);
		
		/* delete person */
		PersonDAL.deletePerson(PersonDAL.getPersons().get(0).getPersonID());
		
	}

}
