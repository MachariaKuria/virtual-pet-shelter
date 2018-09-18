package petshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PetShelter {

	Map<String, VirtualPet> pets = new HashMap<>();

	public void add(VirtualPet pet) {
		pets.put(pet.getPetName(), pet);

	}

	public VirtualPet findPet(String petName) {
		return pets.get(petName);
	}

	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public void adoptPet(VirtualPet pet) {
		pets.remove(pet.getPetName(), pet);

	}

	public void feedPet(String petName, int food) {

		VirtualPet petToFeed = findPet(petName);
		petToFeed.Feed(food);

	}

	public void waterPet(String petName, int water) {

		VirtualPet petToWater = findPet(petName);
		petToWater.Water(water);

	}

	public void feedAllPets() {

		for (VirtualPet pet : pets.values()) {
			pet.FeedPets();
		}

	}

	public void waterAllPets() {
		for (VirtualPet pet : pets.values()) {
			pet.water();
		}

	}

	public void playWithPet(String petName, int play) {
		VirtualPet petToPlayWith = findPet(petName);
		petToPlayWith.petPlay(play);

	}

	public void playWithAllPets() {
		for (VirtualPet pet : pets.values()) {
			pet.playWithPets();
		}

	}

	public void tick() {

		if ((int) (Math.random() * 10) + 1 < 5) {
			for (VirtualPet pet : pets.values()) {
				pet.increaseHunger();
				pet.increaseThirst();
				pet.increaseBoredom();

			}

		}

	}

	public void menuOptions() {
		System.out.println("1. Feed the pets");
		System.out.println("2. Water the pets");
		System.out.println("3. Play with the pets");
		System.out.println("4. Adopt a pet");
		System.out.println("5. Admit a pet");
		System.out.println("6. Quit");

	}

	public void petStatus() {
		System.out.println("Pet status is as shown below:");
		System.out.println();
		System.out.println("Name\t|Hunger\t|Thirst\t|Boredom");
		System.out.println("-------\t|------\t|-------|--------");
		for (Entry<String, VirtualPet> entry : pets.entrySet()) {
			System.out.print(entry.getKey() + "\t|");
			System.out.println(entry.getValue().getHungerLevel() + "\t|" + entry.getValue().getThirstLevel() + "\t|"
					+ entry.getValue().getBoredomLevel());
		}
	}

	public void petDescription() {
		for (Entry<String, VirtualPet> entry : pets.entrySet()) {
			System.out.print("[" + entry.getKey() + "] ");
			System.out.println(entry.getValue().getPetDescription());
		}
	}

}
