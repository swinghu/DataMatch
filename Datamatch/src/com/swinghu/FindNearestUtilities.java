package com.swinghu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class FindNearestUtilities {
	
	public FindNearestUtilities(){
		
	}
	public void  FindnearestUtilities(ArrayList<ArrayList<String>> network){
		for(int i = 0; i<network.size(); i++){
			ArrayList<String> perTestInstance = network.get(i);
		}
		
	}
	public boolean judge(double[] testSequence,double netArr[][]){ //debug true is always returned
		//判断与test实例最近的 训练集是否离其他test实例远
		int token =  min(testSequence);//获取最小训练集,最小值为：testSequence[token]
	
		double tempmin = netArr[0][token];
		for(int i = 1; i<netArr.length; i++){
			if(netArr[i][token] < tempmin){
				tempmin = netArr[i][token];
			}
		}		
		if(tempmin == testSequence[token]){
			System.out.println("the train instance is:"+(token+1)+" the distance is:"+testSequence[token]);
			return true;			
		}
		return false;
	}
	
	public void KNN(double[] testSequence ,int k, int[] knn ){//netArr[i]
		if(k > testSequence.length){
			return ;
		}
		double[] Ex_k = testSequence.clone();
		
		Map map = new HashMap();
		for(int i = 0; i<Ex_k.length; i++ )
		{
			map.put(i+1, Ex_k[i]);
		}
		// 对HashMap中的 value 即Double 进行排序  
		List<Map.Entry<Integer, Double>> id_value = new ArrayList<Map.Entry<Integer, Double>>(map.entrySet());
	    Collections.sort(id_value, new Comparator<Map.Entry<Integer, Double>>() {  
	            public int compare(Map.Entry<Integer, Double> o1,  
	                    Map.Entry<Integer, Double> o2) {  
	                return (o1.getValue()).compareTo(o2.getValue());  
	            }  
	    });
	 // 对HashMap中的 value 进行排序后  显示排序结果  
	    System.out.print("前k个训练集为： ");
	    ArrayList<String> knnlist = new ArrayList<String>();
	    for (int i = 0; i < k; i++) {//输出前k个  
	    	String id = id_value.get(i).toString(); //int+double 类型的字符串
            String[] strarr =id.split("=");
            String str = strarr[0];
            //System.out.println("the str is"+str);
	    	//knn[i] = Integer.valueOf(str);
            knnlist.add(id);
            //System.out.print("前k个训练集为："+id + " ");  
        }  
		for(int i =0; i<k; i++){
			System.out.print(knnlist.get(i)+ "  ");	
		}
		System.out.println();
	    		
		
	}
	
	public void toDoubleArray(ArrayList<ArrayList<String>> network, double netArr[][]){
		
		for(int i = network.size(); i<network.size(); i++){
			ArrayList<String> perLine = network.get(i);
			for(int j = 0; j<perLine.size(); j++){
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
