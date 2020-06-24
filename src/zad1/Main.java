package zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args)
			throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(args[0]));

		List<String> lines = new ArrayList<>();
		for(String line = reader.readLine() ; line != null ; line = reader.readLine())
			lines.add(line);

		reader.close();

		String[] split = lines.get(0).split(" ");

		double capacity = Double.parseDouble(split[0]);
		int elementCount = Integer.parseInt(split[1]);

		System.out.println("Capacity:" + capacity + " Number of elements:" + elementCount);

		split = lines.get(1).split(",");
		double values[] = new double[split.length];
		for(int op = 0 ; op < values.length ; ++ op)
			values[op] = Double.parseDouble(split[op]);

		split = lines.get(2).split(",");
		double weights[] = new double[split.length];
		for(int op = 0 ; op < values.length ; ++ op)
			weights[op] = Double.parseDouble(split[op]);

		System.out.println(lines);


		long generate = 0;

		double max = -1;
		long when = -1;
		double weight = -1;



		for(long op = 0 ; op < Math.pow(2,weights.length) ; ++ op){

			Bag bag = new Bag(capacity);
			long stomp = 1;
			for(int po = weights.length-1 ; po >-1; -- po){

				if((stomp & generate) != 0)
					bag.put(weights[po],values[po]);

				stomp = stomp << 1;

			}

			if(bag.sumValue > max){
				max = bag.sumValue;
				when = generate;
				weight = bag.taken;
			}
			++generate;
			System.out.println("Iteration: " + generate);
			System.out.println("Actual: " + Long.toBinaryString(when));
		}


		System.out.println(Arrays.toString(weights) + " weigths");
		System.out.println(Arrays.toString(values) + " values");
		System.out.println(max + " value");
		System.out.println(weight + " weight");
		System.out.println(Long.toBinaryString(when) + " When");


	}

}
