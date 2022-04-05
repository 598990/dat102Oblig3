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
		System.out.println("Minimal teoretisk h�yde: " + ExtraMethods.minimumHeight(nodes));
		System.out.println("Maksimal teoretisk h�yde: " + ExtraMethods.maximumHeight(nodes));
		System.out.println("Minste h�yde under kj�ring: " + minHeight);
		System.out.println("Maksimal h�yde under kj�ring: " + maxHeight);
		System.out.println("Gjennomsnittlig h�yde: " + totalHeight/iterations);
	}

}
