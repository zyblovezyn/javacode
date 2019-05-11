package com.mail.GeneticsAndCollection.setAndMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
	ģ�⶷�������� 
    ����
    ϴ��
    ����
*/
class CollectionsTest 
{
	public static void main(String[] args) 
	{
        // ����
        ArrayList<String> box=new ArrayList<String>();
       
        
        String[] arr2={"A","J","Q","K"};
        List<String> arr3=new ArrayList<String>();
        for(String s:arr2){
            arr3.add(s);
        }
        for(int i=2;i<11;i++){
             arr3.add(String.valueOf(i));
		       // System.out.println(String.valueOf(i));
        }
         // ��ɫ
        String[] arr={"����","����","����","÷��"};
        // ���ÿһ����
        for(int i=0;i<13;i++){
            for(int j=0;j<4;j++){
                box.add(arr[j]+arr3.get(i).toString());
            }
        }
        box.add("����");
        box.add("С��");
        //ϴ��
        Collections.shuffle(box);
        //System.out.println(box);      
        
        //����
        ArrayList<String> A=new ArrayList<String>();
        ArrayList<String> B=new ArrayList<String>();
        ArrayList<String> C=new ArrayList<String>();
        
        for(int i=0;i<box.size()-3;i++){
            /*
            ģ3����            
            */
            int selected=i%3;
            if(selected==0){
                A.add(box.get(i));
            }else if(selected==1){
                B.add(box.get(i));
            }else if(selected==2){
                C.add(box.get(i));
            }
        }
        System.out.println(box.get(box.size()-1));
        System.out.println(box.get(box.size()-2));
        System.out.println(box.get(box.size()-3));
	}
}
