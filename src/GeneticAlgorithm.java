
public class GeneticAlgorithm {
	public static final int POPULATION_SIZE = 8;
	public static final int[] TARGET_CHROMOSOME = {1,1,0,1,0,0,1,1,1,0};
	public static final int NUM_OF_ELITE_CHROMOSOMES = 1;
	public static final int TOURNAMENT_SELECTION_SIZE = 4;
	private static final double MUTATAION_RATE = 0.25;
	public Population evolve(Population population)
	{
		return mutatePopulation(crossoverPopulation(population));
	}
	private Population crossoverPopulation(Population population)
	{
		Population crossoverPoulation = new Population(population.getChromosome().length);
		for(int x =0; x<NUM_OF_ELITE_CHROMOSOMES; x++)
		{
			crossoverPoulation.getChromosome()[x] = population.getChromosome()[x];
		}
		for(int x = this.NUM_OF_ELITE_CHROMOSOMES; x<population.getChromosome().length; x++)
		{
			Chromosome c1 = this.selectTournamentPopulation(population).getChromosome()[0];
			Chromosome c2 = this.selectTournamentPopulation(population).getChromosome()[0];
			crossoverPoulation.getChromosome()[x] = this.crossoverChromosome(c1, c2);
		}
		return crossoverPoulation;
	} 
	private Population mutatePopulation(Population population)
	{
		Population mutatePoulation = new Population(population.getChromosome().length);
		for(int x =0; x<NUM_OF_ELITE_CHROMOSOMES; x++)
		{
			mutatePoulation.getChromosome()[x] = population.getChromosome()[x];
		}
		for(int x = this.NUM_OF_ELITE_CHROMOSOMES; x<population.getChromosome().length; x++)
		{
			mutatePoulation.getChromosome()[x] = this.mutateChromosome(population.getChromosome()[x]);
		}
		return mutatePoulation;
	}
	private Chromosome crossoverChromosome(Chromosome c1, Chromosome c2)
	{
		Chromosome crossoverChromosome = new Chromosome(TARGET_CHROMOSOME.length);
		for(int x = 0; x<c1.getGenes().length; x++)
		{
			if(Math.random()<0.5)crossoverChromosome.getGenes()[x] = c1.getGenes()[x];
			else crossoverChromosome.getGenes()[x] = c2.getGenes()[x];
		}
		return crossoverChromosome;
	}
	private Population selectTournamentPopulation(Population population)
	{
		Population tournamentPopulation = new Population(TOURNAMENT_SELECTION_SIZE);
		for(int x= 0; x<TOURNAMENT_SELECTION_SIZE; x++)
		{
			tournamentPopulation.getChromosome()[x] = population.getChromosome()[(int)Math.random()*population.getChromosome().length];
		}
		tournamentPopulation.sortChromosomeByFitness();
		return tournamentPopulation;
	}
	private Chromosome mutateChromosome(Chromosome c1)
	{
		Chromosome mutateChromosome = new Chromosome(TARGET_CHROMOSOME.length);
		for(int x = 0; x<c1.getGenes().length; x++)
		{
			if(Math.random()<MUTATAION_RATE)
			{	
				if(Math.random()<0.5)mutateChromosome.getGenes()[x] = 1;
				else mutateChromosome.getGenes()[x] = 0;
			}else{
				mutateChromosome.getGenes()[x] = c1.getGenes()[x];
			}
		}
		return mutateChromosome;
		
	}
}
