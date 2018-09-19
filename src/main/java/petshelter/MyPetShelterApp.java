package petshelter;

import java.util.Scanner;

public class MyPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		PetShelter myPets = new PetShelter();

		myPets.add(new VirtualPet("chui", "Leopard - Has dark spots and is quiet", 5, 4, 3));
		myPets.add(new VirtualPet("duma", "Cheetah - The fast with brown spots", 4, 5, 6));
		myPets.add(new VirtualPet("kifaru", "Rhino - The angrier in the shelter", 2, 8, 5));
		myPets.add(new VirtualPet("nyati", "Cape Buffalo - Is a vegeterian", 8, 1, 6));
		myPets.add(new VirtualPet("simba", "Lion - Has a huge mane", 3, 3, 2));
		myPets.add(new VirtualPet("tembo", "Elephant - The tusker with a trunk", 7, 9, 5));

		System.out.println("Thank you for volunteering at Masha's Pet Shelter!");
		System.out.println();

		myPets.petStatus();
		System.out.println();

		System.out.println("What would you like to do next?");
		System.out.println();
		myPets.menuOptions();
		String userChoice = null;

		do {
			try {
				userChoice = input.nextLine();
				if (userChoice.equals("1")) {
					myPets.feedAllPets();
					myPets.petStatus();
					myPets.tick();
					System.out.println();
					System.out.println("What else did you want to do?");
					System.out.println();
					myPets.menuOptions();
				} else if (userChoice.equals("2")) {
					myPets.waterAllPets();
					myPets.petStatus();
					myPets.tick();
					System.out.println();
					System.out.println("What else did you want to do?");
					System.out.println();
					myPets.menuOptions();
				} else if (userChoice.equals("3")) {

					System.out.println("Would you like to play with one pet y/n?");
					System.out.println();
					String userAns = input.nextLine();
					while (!userAns.equalsIgnoreCase("n")) {
						System.out.println("List of pets.");
						System.out.println();
						myPets.petDescription();
						System.out.println();
						System.out.println("Which pet would you like to play with?");
						System.out.println();
						String petToPlayWith = input.nextLine();
						myPets.findPet(petToPlayWith);
						if(myPets.findPet(petToPlayWith.toLowerCase()) != null) {
							System.out.println("Enter the playtime as integer!");
							int playTime = input.nextInt();
							input.nextLine();
							myPets.playWithPet(petToPlayWith, playTime);
							myPets.petStatus();	
						}else {
							System.out.println("Pet doesn't exist.");
						}
						System.out.println("Do you want to play with another pet y/n?");
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

				} else if (userChoice.equals("4")) {
					System.out.println("Okay, select a pet from the pet list below that you want to adopt.");
					System.out.println();
					myPets.petDescription();
					String petToAdopt = input.nextLine();
					if(myPets.findPet(petToAdopt.toLowerCase()) != null) {
					myPets.adoptPet(myPets.findPet(petToAdopt.toLowerCase()));
					myPets.petStatus();
					myPets.tick();
					}else {
						System.out.println("That pet doesn't exist");
					}
					System.out.println();
					System.out.println("What else did you want to do?");
					System.out.println();
					myPets.menuOptions();
				} else if (userChoice.equals("5")) {
					System.out.println("Below is the Pet List.");
					System.out.println();
					myPets.petDescription();
					System.out.println();
					System.out.println("Enter pet name would you like to admit?");
					String petName = input.nextLine();
					if (myPets.findPet(petName.toLowerCase()) == null) {
						System.out.println("Enter description of pet you like to admit?");
						String petDesc = input.nextLine();
						myPets.add(new VirtualPet(petName, petDesc, 10, 14, 13));
						myPets.petStatus();
						myPets.tick();
						System.out.println();
						System.out.println("What else did you want to do?");
						System.out.println();
						myPets.menuOptions();
					} else {
						System.out.println("That pet already exists in the shelter, please choose another pet");
						petName = input.nextLine();
						myPets.petStatus();
					}
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

		} while (!userChoice.equals("6"));

		System.out.println("Thanks for volunteering..GoodBye!");
		System.exit(0);
		input.close();

	}

}
