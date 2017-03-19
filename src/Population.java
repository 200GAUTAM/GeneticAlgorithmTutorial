import java.util.Arrays;
import java.util.Comparator;

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
	
	public Chromosome[] getChromosome()
	{
		return chromosome;
	}
	
	
	public void sortChromosomeByFitness()
	{
		Arrays.sort(this.chromosome, new ChromosomeComparator());
				
	}
}

class ChromosomeComparator implements Comparator<Chromosome>
{

	@Override
	public int compare(Chromosome o1, Chromosome o2) {
		int flag = 0;
		if(o1.getFitness()>o2.getFitness()) flag = -1;
		else if(o1.getFitness()<o2.getFitness()) flag = 1;
		return flag;
		
	}
	
}
