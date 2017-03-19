import java.util.Arrays;

public class Chromosome {
	private boolean isFitnessChanged = true;
	private int fitness = 0;
	private int gene[];
	public Chromosome(int length)
	{
		gene = new int[length];
	}
	public Chromosome initializeChromosome()
	{
		for(int x = 0; x<gene.length; x++)
		{
			if(Math.random()>0.5) gene[x] = 1;
			else gene[x] = 0;
		}
		return this;
	}
	public int[] getGenes()
	{
		isFitnessChanged = true;
		return this.gene;
	}
	public int getFitness()
	{
		if(isFitnessChanged)
		{
			fitness = recalculateFitness();
			isFitnessChanged = false;
		}
		return fitness;
	}
	public int recalculateFitness()
	{
		int chromosomeFitness = 0;
		for(int x = 0; x<gene.length; x++)
		{
			if(gene[x] == GeneticAlgorithm.TARGET_CHROMOSOME[x])chromosomeFitness++;
		}
		return chromosomeFitness;
	}
	public String toString()
	{
		return Arrays.toString(this.gene);
	}
}
