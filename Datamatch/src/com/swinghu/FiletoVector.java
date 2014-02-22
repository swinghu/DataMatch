package com.swinghu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class FiletoVector {
	private static String tstfilePrefix = "F:/实验数据/introduction/testing";
	private static String trnfilePrefix = "F:/实验数据/introduction/training";	
	ArrayList<ArrayList<String>> testFileArrList = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> trainFileArrList = new ArrayList<ArrayList<String>>();
	
	public ArrayList<ArrayList<String>> getTrainFileArrList() {
		return trainFileArrList;
	}
	
	public void setTrainFileArrList(ArrayList<ArrayList<String>> trainFileArrList) {
		this.trainFileArrList = trainFileArrList;
	}
	
	public ArrayList<ArrayList<String>> getTestFileArrList() {
		return testFileArrList;
	}
	
	public void setTestFileArrList(ArrayList<ArrayList<String>> testFileArrList) {
		this.testFileArrList = testFileArrList;
	}

	public FiletoVector() throws IOException {
		ArrayList<String> FileList = StoreimportFile("F:/实验数据/introduction");//获取目录下面的文件名
		//FiletoVector fv = new FiletoVector(trnfilePrefix);
		ArrayList persubfile = this.StoreimportFile(trnfilePrefix);
		
		 trainFileArrList = this.readLinetoArrList(trnfilePrefix+"/3.txt");//生成第i个文件的ArrayList
		 testFileArrList  = this.readLinetoArrList(tstfilePrefix+"/3.txt");//生成第i个文件的ArrayList
	}
	
	//utilitis
	public  ArrayList<String> StoreimportFile(String filePrefix) throws NullPointerException  {
	
		File currentdir  = new File(filePrefix);
	
		ArrayList allSubFileList = new ArrayList<String>();//存储训练集合测试集目录中的文件 :x.arff
		
		if(!currentdir.exists()){
			System.out.println("该文件目录不存在");
			return null;
		}
		String[] subFiles = currentdir.list();
		for(int i = 0; i<subFiles.length; i++){
			allSubFileList.add(filePrefix +"/"+ subFiles[i]);			
		}
		return allSubFileList;//返回filePrefix目录下所有文件
	}
	
	public  ArrayList<ArrayList<String>>  readLinetoArrList(String filepath) throws IOException{

		ArrayList<ArrayList<String>> perFileArr2List = new ArrayList<ArrayList<String>>();
		ArrayList<String> perLineList = new ArrayList<String>();
		
		File sf = new File(filepath);
		FileReader fr = new FileReader(sf);
		BufferedReader  bufferReader = new BufferedReader (fr);
		String perLine = null;
		while((perLine  = bufferReader.readLine()) != null){
			if (!perLine.startsWith("@")){
				perLineList = processPerLine(perLine);	//返回一个实例(一行)
				perFileArr2List.add(perLineList);
			}
		}		
		return perFileArr2List;		
	}
	
	public ArrayList<String> processPerLine(String line){ 
		ArrayList perDimNumList = new ArrayList<String>();
		String dimnum[] = line.split(",");
		for(int i = 0 ; i <dimnum.length-1; i++){
			perDimNumList.add(dimnum[i]);
		}
		return perDimNumList;
		
	}
	
}
