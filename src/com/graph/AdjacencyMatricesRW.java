package com.graph;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Rubanraj Ravichandran
 */
public class AdjacencyMatricesRW {

	public AdjacencyMatrices readMatrix(String fileName) {
		Scanner read;
		int nodeSize = getNodeSize(fileName);
		AdjacencyMatrices matrix = new AdjacencyMatrices(nodeSize);
		String[] row;

		try {
			read = new Scanner(new File(fileName + ".txt"));
			int i = 0;
			while (read.hasNext()) {
				String line = read.nextLine();
				row = line.split(" ");
				for (int j = 0; j < nodeSize; j++) {
					if (!row[j].equals("0")) {
						matrix.addEdge(i, j, Integer.parseInt(row[j]));
					}
				}
				i++;
			}
			read.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}

		return matrix;
	}

	private int getNodeSize(String fileName) {

		Scanner read;
		int count = 0;
		try {
			read = new Scanner(new File(fileName + ".txt"));
			while (read.hasNext()) {
				read.nextLine();
				count++;
			}
			read.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void writeMatrix(AdjacencyMatrices matrix, String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName + ".txt"));
			out.write(matrix.toString());
			out.close();
		} catch (IOException e) {
			e.getMessage();
			System.out.println("File not found");
		}
	}

}
