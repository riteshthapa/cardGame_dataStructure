package project1;

public class Main {

	public static void main(String[] args) {
		Deck<Integer> list = new Deck<>();

		for (int i = 0; i < 5; i++) {
			list.add(i+1);
		}

		System.out.println("The size of a given Deck is " + list.size() + "\n");

		System.out.println("Deck of cards:");
		for (Integer x : list) {
			System.out.print(x + " ");
		}

		list.shuffle();

		System.out.println("\nDeck of cards after shuffling:");
		for (Integer x : list) {
			System.out.print(x + " ");
		}
	}
}