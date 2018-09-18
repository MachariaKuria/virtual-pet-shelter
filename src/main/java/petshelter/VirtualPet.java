package petshelter;

public class VirtualPet {

	private String petName;
	private String petDescription;
	private int hungerLevel;
	private int thirstLevel;
	private int boredomLevel;

	public VirtualPet(String petName, String petDescription, int hungerLevel, int thirstLevel, int boredomLevel) {
		this.petName = petName;
		this.petDescription = petDescription;
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.boredomLevel = boredomLevel;
	}

	public String getPetDescription() {
		return petDescription;
	}

	public String getPetName() {

		return petName;
	}

	public int getHungerLevel() {

		return hungerLevel;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public int getBoredomLevel() {
		return boredomLevel;
	}

	public void Feed(int food) {
		hungerLevel -= food;

	}

	public void Water(int water) {

		thirstLevel -= water;

	}

	public void FeedPets() {
		hungerLevel -= 10;

	}

	public void water() {
		thirstLevel -= 10;

	}

	public void petPlay(int play) {
		boredomLevel -= play;

	}

	public void playWithPets() {
		boredomLevel -= 10;

	}

	public void increaseHunger() {
		hungerLevel += 30;

	}

	public void increaseThirst() {
		thirstLevel += 30;

	}

	public void increaseBoredom() {
		boredomLevel += 30;

	}
}
