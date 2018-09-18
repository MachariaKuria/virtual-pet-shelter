package petshelter;

import java.util.Scanner;

public class MyPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		PetShelter myPets = new PetShelter();

		myPets.add(new VirtualPet("Chui", "Has dark spots and is quiet.", 5, 4, 3));
		myPets.add(new VirtualPet("Duma", "The fast with brown spots.", 4, 5, 6));
		myPets.add(new VirtualPet("Kifaru", "The angrier in the shelter.", 2, 8, 5));
		myPets.add(new VirtualPet("Nyati", "Is a vegeterian.", 8, 1, 6));
		myPets.add(new VirtualPet("Simba", "Has a huge mane.", 3, 3, 2));
		myPets.add(new VirtualPet("Tembo", "The tusker with a trunk.", 7, 9, 5));

		System.out.println("Thank you for volunteering at Masha's Pet Shelter!");
		System.out.println();

		myPets.petStatus();
		System.out.println();

		System.out.println("What would you like to do next?");
		System.out.println();
		myPets.menuOptions();
		String userChoice;

		do {

			userChoice = input.nextLine();
			if (userChoice.equals("1")) {
				myPets.feedAllPets();
				myPets.petStatus();
				myPets.tick();
			} else if (userChoice.equals("2")) {
				myPets.waterAllPets();
				myPets.petStatus();
				myPets.tick();
			} else if (userChoice.equals("3")) {
				try {
					System.out.println("Would you like to play with one pet y/n?");
					System.out.println();
					String userAns = input.nextLine();
					while (!userAns.equalsIgnoreCase("n")) {
						System.out.println("Okay, please choose one.");
						System.out.println();
						myPets.petDescription();
						System.out.println();
						System.out.println("Which pet would you like to play with?");
						System.out.println();
						String petToPlayWith = input.nextLine();
						myPets.findPet(petToPlayWith);
						myPets.playWithPet(petToPlayWith, 5);
						myPets.petStatus();
						System.out.println("Would you still want to play with one pet y/n?");
						userAns = input.nextLine();
					}
					myPets.playWithAllPets();
					myPets.petStatus();
					System.out.println();
					System.out.println("What else did you want to do?");
					System.out.println();
					myPets.menuOptions();
					System.out.println();
					myPets.tick();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			} else if (userChoice.equals("4")) {
				System.out.println("Okay, select the pet you want to adopt.");
				System.out.println();
				myPets.petDescription();
				String petToAdopt = input.nextLine();
				myPets.adoptPet(myPets.findPet(petToAdopt));
				myPets.petStatus();
				myPets.tick();

			} else if (userChoice.equals("5")) {
				System.out.println("Below is the Pet List.");
				System.out.println();
				myPets.petDescription();
				System.out.println("Enter pet name would you like to admit?");
				String petName = input.nextLine();
				if(myPets.findPet(petName) == null) {
					System.out.println("Enter description of pet you like to admit?");
					String petDesc = input.nextLine();
					myPets.add(new VirtualPet(petName,petDesc,10,14,13));
					myPets.petStatus();
					myPets.tick();					
				}else {
					System.out.println("That pet already exists the shelter, please choose another pet");
				}

			}

		} while (!userChoice.equals("6"));

		System.out.println("Thanks for volunteering..GoodBye!");
		System.exit(0);
		input.close();

	}

}
