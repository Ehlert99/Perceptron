import java.util.ArrayList;
import java.util.Random;

public class Neuron {

  private final int numberOfInputSignals;              // number of dendrits
  private double[] weights;
  private final ArrayList<Neuron> nextNeurons;

  public Neuron(int numberOfInputSignals, ArrayList<Neuron> nextNeurons, double bias) {
    this.numberOfInputSignals = numberOfInputSignals;
    weights = new double[numberOfInputSignals + 1];    // + 1: bias!
    setRandomWeights();
    setBias(bias);
    this.nextNeurons = nextNeurons;
  }

  public Neuron(int numberOfInputSignals, ArrayList<Neuron> nextNeurons) {
    this(numberOfInputSignals, nextNeurons, getRandomValue());
  }

  public double[] getWeights() {
    return weights;
  }

  public double getWeights(int i) {
    return weights[i];
  }

  public void setWeights(int i, double weight) {
    weights[i] = weight;
  }

  public void setBias(double bias) {
    weights[weights.length - 1] = bias;
  }

  private void setRandomWeights() {
    for (int i = 0; i < weights.length - 1; i++)
       weights[i] = getRandomValue();
  }

  private static double getRandomValue() {
    Random random = new Random();
    return 2 * random.nextDouble() - 1;                // -1 < weight < +1
  }

  public double getOutput(double[] x, ActivationFunction activationFunction) {
    double output = 0;
    for (int i = 0; i < numberOfInputSignals; i++)
      output += x[i] * weights[i];
    output += 1 * weights[numberOfInputSignals];       // bias!
    switch (activationFunction) {
      case HEAVISIDE:
        output = Activation.activateWithHeaviside(output);
        break;
      case SIGMOID:
        output = Activation.activateWithSigmoid(output);
        break;
      case ONLYSUM:
      default:
        break;
    }
    return output;
  }

}
