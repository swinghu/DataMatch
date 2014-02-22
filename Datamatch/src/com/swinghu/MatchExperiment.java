package com.swinghu;

import java.io.IOException;
import java.util.ArrayList;

public class MatchExperiment {
	private static int k = 1;//定义knn算法的k
	public static void main(String args[]) throws IOException{
		DataMatch dm = new DataMatch();
		FiletoVector vectorFile;
		vectorFile = new FiletoVector();
		ArrayList<ArrayList<String>> testArrList  = vectorFile.getTestFileArrList();
		ArrayList<ArrayList<String>> trainArrList = vectorFile.getTrainFileArrList();
		ArrayList<ArrayList<String>> distNet = dm.caclDistanceNet(testArrList,trainArrList);//为每个test找一个train
		//dm.screenShow(distNet);//输出文件到 txt
		
		double[][]  netArr;
		netArr = new double[testArrList.size()][trainArrList.size()];
		
		dm.toDoubleArray(distNet, netArr);//ArrayList to double array;
		System.out.println("netArr size is:"+netArr.length);
		int[] knn = null;
		for(int i = 0; i<netArr.length; i++){			
			if((new FindNearestUtilities()).judge(netArr[i],netArr) == true){
			}else{
				System.out.print("Not Found ,Using KNN-----");
				(new FindNearestUtilities()).KNN(netArr[i],k,knn);//使用knn算法求最近几个点						
			}
			
		}
		

	}
}
