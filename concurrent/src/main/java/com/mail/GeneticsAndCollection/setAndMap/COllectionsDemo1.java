/*
	模拟斗地主发牌 
    买牌
    洗牌
    发牌
*/
class CollectionsTest 
{
	public static void main(String[] args) 
	{
        // 买牌
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
         // 花色
        String[] arr={"红桃","黑桃","方块","梅花"};
        // 添加每一张牌
        for(int i=0;i<13;i++){
            for(int j=0;j<4;j++){
                box.add(arr[j]+arr3.get(i).toString());
            }
        }
        box.add("大王");
        box.add("小王");
        //洗牌
        Collections.shuffle(box);        
        //System.out.println(box);      
        
        //发牌
        ArrayList<String> A=new ArrayList<String>();
        ArrayList<String> B=new ArrayList<String>();
        ArrayList<String> C=new ArrayList<String>();
        
        for(int i=0;i<box.size()-3;i++){
            /*
            模3运算            
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
