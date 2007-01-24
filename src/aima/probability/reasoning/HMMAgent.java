package aima.probability.reasoning;

import aima.probability.RandomVariable;

public class HMMAgent {
	private HiddenMarkovModel hmm;
	private RandomVariable belief;

	public HMMAgent(HiddenMarkovModel hmm ){
		this.hmm = hmm;
		this.belief = hmm.priorDistribution.duplicate();
	}
	
	public RandomVariable belief() {
		return belief;
	}
	

	
	public void act(String action) {
		belief = hmm.predict(belief,action);
	}

	public void waitForPerception() {
		act(HmmConstants.DO_NOTHING);
	}
	
	public void perceive(String perception) {

		belief = hmm.perceptionUpdate(belief,perception);
		
	}

}