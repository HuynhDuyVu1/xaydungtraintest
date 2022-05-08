/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traintest;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.instance.RemovePercentage;

/**
 *
 * @author vuhuy
 */
public class MyTrainTest {
    DataSource source;
    Instances dataset;
    String[] model_options;
    String[] data_options;
    Instances trainset;
    Instances testset;
    public MyTrainTest() {
    }

    public MyTrainTest(String filename,
                            String m_opts, 
                            String d_opts) throws Exception {
        this.source = new DataSource(filename);
        this.dataset = source.getDataSet();
        if (m_opts != null ){
              this.model_options = weka.core.Utils.splitOptions(m_opts);
        }
        if (d_opts != null ){
               this.data_options = weka.core.Utils.splitOptions(d_opts);
        }
    }

    
     public Instances removeData(Instances originalData) throws Exception{
        Remove remove = new Remove();
        remove.setOptions(data_options);
        remove.setInputFormat(originalData);
        return Filter.useFilter(originalData, remove);
    }
        
    public Instances divideTrainTest(Instances originalSet,
            double percent, boolean isTest) throws Exception{
        RemovePercentage rp = new RemovePercentage();
            rp.setPercentage(percent);
            rp.setInvertSelection(isTest);
            rp.setInputFormat(originalSet);
            return Filter.useFilter(originalSet, rp);
            
        
    }
    
    public void saveModel(String filename, Object model) throws Exception{
      weka.core.SerializationHelper.write(filename, model);
    }
    
    @Override
    public String toString() {
        return dataset.toString();
    }
    
    
}
