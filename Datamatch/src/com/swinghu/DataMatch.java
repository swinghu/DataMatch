package com.swinghu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class DataMatch {
	
	private ArrayList<ArrayList<String>> distanceNet;

	
	public ArrayList<ArrayList<String>> getDistanceNet() {
		return distanceNet;
	}

	public void setDistanceNet(ArrayList<ArrayList<String>> distanceNet) {
		this.distanceNet = distanceNet;
	}
	
	public DataMatch(){
	
	}
	
	public ArrayList<ArrayList<String>> caclDistanceNet(ArrayList<ArrayList<String>> testArrList , ArrayList<ArrayList<String>> trainArrList){
		ArrayList<ArrayList<String>> tmpDistanceNet = new ArrayList<ArrayList<String>>();
		for(int itst = 0; itst < testArrList.size(); itst++ ){
			ArrayList<String> testDistList = new ArrayList<String>();
			for(int itrn = 0; itrn < trainArrList.size(); itrn++){
				double distance = caclDistance(testArrList.get(itst),trainArrList.get(itrn));
				testDistList.add(Double.toString(distance));				
			}
			tmpDistanceNet.add(testDistList);
		}
		return tmpDistanceNet;
	}
	
	public double  caclDistance(ArrayList<String> strTrain,ArrayList<String> strTest){		
		double squreValue = 0;
		
		for(int i = 0; i < strTrain.size(); i++	){
			double perTrainDim = Double.valueOf(strTrain.get(i)).doubleValue();
			double perTestDim = Double.valueOf(strTest.get(i)).doubleValue();
			double minusValue = perTrainDim-perTestDim;
			squreValue += Math.pow(minusValue,2);
		}		
		return Math.sqrt(squreValue);
	}
	
	public void screenShow(ArrayList<ArrayList<String>> showDistNet ) throws NullPointerException, IOException{
		String path= "F:/实验数据/introduction/testout.txt"+(int)Math.random();

		FileWriter fw = new FileWriter(path,true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(int i = 0; i< showDistNet.size(); i++){
			ArrayList<String> perLine = showDistNet.get(i);
			for(int j = 0; j<perLine.size(); j++){
				
				//System.out.print(perLine.get(j)+"---");
				bw.write(perLine.get(j)+"---");								
			}
			bw.newLine();	
			//ystem.out.println();
		}
	}
	
	public void  FindnearestUtilities(ArrayList<ArrayList<String>> network){
		for(int i = 0; i<network.size(); i++){
			ArrayList<String> perTestInstance = network.get(i);
		}
		
	}
	public boolean judge(double[] testSequence,double netArr[][]){
		//判断与test实例最近的 训练集是否离其他test实例远
		int token =  min(testSequence);//获取最小训练集,最小值为：testSequence[token]
		double tempmin = netArr[0][token];
		for(int i = 1; i<netArr.length; i++){
			if(netArr[i][token] < tempmin){
				tempmin = netArr[i][token];
			}
		}		
		if(tempmin == testSequence[token]){
			return true;
		}
		return false;
	}
	public void toDoubleArray(ArrayList<ArrayList<String>> network, double netArr[][]){
		
		for(int i = 0; i<network.size(); i++){
			
			ArrayList<String> perLine = network.get(i);
			for(int j = 0; j<perLine.size(); j++){
				//System.out.println("the perLine is : "+perLine.get(j));
				netArr[i][j] = Double.valueOf(perLine.get(j));
			}
		}
	}
	
	public int max(double[] sequence ){
		double max_value = sequence[0];
		int token = 0;
		for(int i = 1; i<sequence.length; i++){
			if(max_value < sequence[i]){
				max_value = sequence[i];
				token = i;
			}
		}
		return token;
	}
	public int min(double[] sequence ){
		double min_value = sequence[0];
		int token = 0;
		for(int i = 1; i<sequence.length; i++){
			if(min_value > sequence[i]){
				min_value = sequence[i];
				token = i;
			}
		}
		return token;
	}
	
}
