
public class Chromosome {
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
}
