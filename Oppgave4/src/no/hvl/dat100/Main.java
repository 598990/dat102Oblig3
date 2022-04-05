package no.hvl.dat100;

import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		int iterations = 100;
		int nodes = 8191;
		SoektreInterface<Integer> tree = null;
		int minHeight = nodes;
		int maxHeight = -1;
		int totalHeight = 0;
		
		for(int i = 0; i < iterations; i++) {
			tree = new BS_Tre<Integer>((int)Math.floor(Math.random()*nodes));
			for(int j = 0; j < nodes-1; j++) {
				tree.leggTil((int)Math.floor(Math.random()*nodes));
			}
			if(tree.hoyde() < minHeight) {
				minHeight = tree.hoyde();
			}
			if(tree.hoyde() > maxHeight) {
				maxHeight = tree.hoyde();
			}
			
			totalHeight += tree.hoyde();
		}
		
		System.out.println("Antall noder: " + tree.antall()); // Will be same as nodes variable
		System.out.println("Minimal teoretisk høyde: " + ExtraMethods.minimumHeight(nodes));
		System.out.println("Maksimal teoretisk høyde: " + ExtraMethods.maximumHeight(nodes));
		System.out.println("Minste høyde under kjøring: " + minHeight);
		System.out.println("Maksimal høyde under kjøring: " + maxHeight);
		System.out.println("Gjennomsnittlig høyde: " + totalHeight/iterations);
	}

}
