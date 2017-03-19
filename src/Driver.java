import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Population population = new Population(GeneticAlgorithm.POPULATION_SIZE);
		population.initializePopulation();
		GeneticAlgorithm gneticalgorithm = new GeneticAlgorithm();
		System.out.println("-----------------------------------------------------");
		System.out.println("Generation # 0" + "|Fittest Chomosome fitness " + population.getChromosome()[0].getFitness());
		printPopulation(population, "Target Chromosome: " + Arrays.toString(GeneticAlgorithm.TARGET_CHROMOSOME) );
		int generationNumber = 0;
		while(population.getChromosome()[0].getFitness()<GeneticAlgorithm.TARGET_CHROMOSOME.length)
		{
			generationNumber++;
			System.out.println("\n-----------------------------------------------------");
			population = gneticalgorithm.evolve(population);
			population.sortChromosomeByFitness();
			System.out.println("Generation #" + generationNumber + "|Fittest Chomosome fitness " + population.getChromosome()
			[0].getFitness());
			printPopulation(population, "Target Chromosome: " + 
			Arrays.toString(GeneticAlgorithm.TARGET_CHROMOSOME) );
				
		}
	}
	
	public static void printPopulation(Population population, String heading)
	{
		System.out.println(heading);
		System.out.println("-----------------------------------------------------");
		for(int x = 0; x<population.getChromosome().length; x++)
		{
			System.out.println("Chromosome # " + x + " : " +
						Arrays.toString(population.getChromosome()[x].getGenes()) +
					 " | Fitness: " + population.getChromosome()[x].getFitness() );
		}
	}

}
