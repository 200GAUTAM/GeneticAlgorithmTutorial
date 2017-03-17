
public class Population {
	private Chromosome chromosome[];
	
	public Population(int length)
	{
		chromosome = new Chromosome[length];
	}
	public Population initializePopulation()
	{
		for(int x = 0; x<chromosome.length; x++)
		{
			chromosome[x] = new Chromosome(GeneticAlgorithm.TARGET_CHROMOSOME.length).initializeChromosome();
			
		}
		sortChromosomeByFitness();
		return this;
	}
	
	public void sortChromosomeByFitness(){}
}
