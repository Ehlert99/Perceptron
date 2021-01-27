/**
 * @version 4.0 / 17.10.2020
 * @author  Dr. Albrecht Ehlert
 */

public class MachineLearningMain {

  public static void main(String[] args) {

    MachineLearning machineLearning = new MachineLearning();

    machineLearning.showWeights();
    machineLearning.testAllInputsAndShowResults();
        
    machineLearning.trainWithSupervisedLearning();

    machineLearning.showWeights();
    machineLearning.testAllInputsAndShowResults();

  }

}
