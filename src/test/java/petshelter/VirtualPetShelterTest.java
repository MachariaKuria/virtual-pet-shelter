package petshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	PetShelter underTest;
	VirtualPet pet1;
	VirtualPet pet2;

	// Nyati,simba,tembo,chui,kifaru

	@Before
	public void setUp() {
		underTest = new PetShelter();
		pet1 = new VirtualPet("Simba", "Has a mane", 5, 5, 5);
		pet2 = new VirtualPet("Chui", "Has dark spots", 15, 15, 15);
	}

	@Test
	public void shouldBeAbleToAddAPet() {
		underTest.add(pet1);
		VirtualPet allowPetIntake = underTest.findPet("Simba");
		assertThat(allowPetIntake, is(pet1));
	}

	@Test
	public void shouldBeAbleToAdd2Pets() {
		underTest.add(pet1);
		underTest.add(pet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(2,allPets.size());
	}
	
	@Test
	public void shouldBeAbleToRemoveAPet() {
		underTest.add(pet1);
		underTest.adoptPet(pet1);
		VirtualPet allowPetAdoption = underTest.findPet(pet1.getPetName());
		assertThat(allowPetAdoption, is(nullValue()));
	}
	
	@Test
	public void shouldBeAbleToFeedAPet() {
		
		underTest.add(pet2);
		underTest.feedPet(pet2.getPetName(),5);
		assertThat(pet2.getHungerLevel(),is(10));
	}
	

	@Test
	public void shouldBeAbleToFeedAllPets() {
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.feedAllPets();
		assertThat(pet1.getHungerLevel(),is(-5));
		assertThat(pet2.getHungerLevel(),is(5));
	}
	@Test
	public void shouldBeAbleToWaterAPet() {
		
		underTest.add(pet2);
		underTest.waterPet(pet2.getPetName(),5);
		assertThat(pet2.getThirstLevel(),is(10));
	}
	@Test
	public void shouldBeAbleToWaterAllPets() {
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.waterAllPets();
		assertThat(pet1.getThirstLevel(),is(-5));
		assertThat(pet2.getThirstLevel(),is(5));
	}	
	@Test
	public void shouldBeAbleToPlayWithAPet() {
		
		underTest.add(pet2);
		underTest.playWithPet(pet2.getPetName(),5);
		assertThat(pet2.getBoredomLevel(),is(10));
	}
	
	@Test
	public void shouldBeAbleToPlayWithAllPets() {
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.playWithAllPets();
		assertThat(pet1.getBoredomLevel(),is(-5));
		assertThat(pet2.getBoredomLevel(),is(5));
	}	
	
	@Test
	public void HungerShouldGoUpWithOneTick() {
		underTest.tick();
		pet1.increaseHunger();
		assertEquals(pet1.getHungerLevel(),35);
	}
}
