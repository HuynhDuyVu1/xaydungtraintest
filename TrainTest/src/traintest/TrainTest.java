/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traintest;

/**
 *
 * @author vuhuy
 */
public class TrainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        MyTrainTest model = new MyTrainTest(
        "C:\\Program Files\\Weka-3-8-6\\data\\glass.arff",null,null);
        model.trainset = model.divideTrainTest(model.dataset, 30, false);
        model.testset = model.divideTrainTest(model.dataset, 30, true);
        System.out.println(model);
        System.out.println(model.trainset.toSummaryString());
        System.out.println(model.testset.toSummaryString());
        model.saveModel("D:\\Data\\glass_train.arff", model.trainset);
        model.saveModel("D:\\Data\\glass_test.arff", model.testset);
    }
    
}
