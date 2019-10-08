
import java.util.Scanner;
import java.util.Arrays; 
public class Set_UI {
    public static int m=0;
    // static int [][] Array;
    public static int[] union (String x,String y,int[][]array)
    {
         String a=""+x.charAt(1);
        String b=""+y.charAt(1);
        int row1=Integer.parseInt(a);
        int row2=Integer.parseInt(b);
        int unset[]=new int [array[0].length];
        for(int j=0;j<array[0].length;j++)
        {
            if((array[row1][j]==1)||(array[row2][j]==1))
            {
                unset[j]=1;
            }
        }
        return unset;
    }
    
    public static String [] Complement (String x,int[][]array,String []narr)
    {
        String a=""+x.charAt(1);
         int row1=Integer.parseInt(a);
         String unset[]=new String [array[0].length];
         for(int j=0;j<array[0].length;j++)
         {
             if((array[row1][j]==0))
             {
                 unset[j]=narr[j];
                 m++;
             }
         }
        
         return unset;
    }
    public static void main(String[] args) {
        
        // TODO Auto-generated method stub
        System.out.println("Please choose an action");
        System.out.println("-----------------------");
        System.out.println("1- Set the universal set\r\n" + 
                "2- Set a supset \r\n" + 
                "3- Intersection of two sets\r\n" + 
                "4- Union of two sets\n"+
                "5- Complement of a set"
                        );
        System.out.println("====================================================================");
        Scanner scan=new Scanner(System.in);
        int num_of_operation=scan.nextInt();
        int s=1;
         int [][] Array = null;
         String[] arr = null;
         String[] narr = null;
        while(true)
        {
            int found=0;
            if((0<num_of_operation)&&(num_of_operation<8))
            {
                found=1;
            }
            else 
            {
                System.out.println("please Enter number from 1 to 6 to Chose the Operation");
                num_of_operation=scan.nextInt();
                while((0>num_of_operation)||(num_of_operation>7))
                {
                    System.out.println("please Enter number from 1 to 6 to Chose the Operation");
                    num_of_operation=scan.nextInt();
                }
            }
            if(found==1)
            {
             
                    
                if(num_of_operation==1)
                {
                    System.out.println("Insert the Universal Set :");
                    String Uset=scan.next();
                    arr =Uset.split(",");
                    
                    Arrays.sort(arr);
                   int c=0;
                   for(int i=arr.length-1;i>0 ;i--)
                   {
                       
                     if (arr[i].contentEquals(arr[i-1]))
                     {
                         c++;
                         arr[i]="F";
                     }
                   }
                   int size=arr.length-c;
                   c=0;
                   narr = new String [size];
                   for(int i=0;i<arr.length;i++)
                   {
                     if (arr[i]!="F")
                     {
                         narr[c]=arr[i];
                         c++;
                     }
                   }
                   Array=new int [10][narr.length];
                   for(int i=0;i<narr.length;i++)
                  {
                    Array[0][i]=1;
                  }
                   
            }
                    
                

                else if(num_of_operation==2)
                {
                    System.out.println("Insert S"+ s +"===>");
                    
                    String Subset=scan.next();
                    String[] help =Subset.split(",");
                    
                    
                    
                    for(int i=0;i<help.length;i++)
                    {
                        for(int j=0;j<narr.length;j++)
                        {
                            if(help[i].contentEquals(narr[j]))
                            {
                                Array[s][j]=1;  
                                break;
                            }
                                
                        }
                        
                    }
                    s++;
                }
                else if(num_of_operation==3)
                {
                        String intersec[]=new String [narr.length];
                        System.out.println("choose two sets");
                        String S1=scan.next();
                        String S2=scan.next();
                        int ind1=S1.charAt(1)-'0';
                        int ind2=S2.charAt(1)-'0';
                        int k=0;
                        int max =Math.max(ind1,ind2 );
                        for (int i=0;i<narr.length;i++)
                        {
                            if ((Array[ind1][i]==Array[ind2][i])&& Array[ind1][i]==1 )
                            {
                                intersec[k]=arr[i];
                                k++;
                            }
                        }
                        
                        for (int i=0;i<k;i++)
                        {
                            System.out.print(intersec[i]);
                            if (i!=k-1)
                            {
                                System.out.print(",");
                            }
                        }
                        System.out.print('\n');
                        
                }else if(num_of_operation==4)
                {
                    System.out.println("Choice the name of two Sets from:");
                    for(int i=1;i<=(s-1);i++)
                    {
                        System.out.print("s"+i+" ");
                    }
                    System.out.println();
                    String name1=scan.next();
                    String name2=scan.next();
                    int []un=union ( name1,name2,Array);
                    int found1=1;
                    for(int i=0;i<un.length;i++)
                    {
                        if(un[i]==1)
                        {
                            if(found1==1)
                            {
                                System.out.print(narr[i]);
                                found1=0;
                            }
                            else
                            {
                                System.out.print(","+narr[i]);
                            }
                            
                        }
                    }
                    System.out.println();
                    
                }else if(num_of_operation==5)
                {
                     System.out.println("Choice the name of Set from:");
                     for(int i=1;i<=(s-1);i++)
                     {
                         System.out.print("s"+i+" ");
                     }
                     System.out.println();
                     String name1=scan.next();
                     String []un=Complement ( name1,Array,narr);
                     int found1=1;
                     int count =0;
                     for(int i=0;i<un.length;i++)
                     {
                         if(un[i]!=null)
                         {
                             count++;
                         }
                     }
                     String []help =new String [count];
                     int e=-1;
                     for (int i=0;i<un.length;i++)
                     {
                         
                         if(un[i]!=null)
                         {
                             System.out.print(un[i]);
                            // System.out.println(m);
                             e++;
                             //System.out.println(e);
                             if (e!=m-1)
                             {
                                 System.out.print(",");
                             }
                         }
                        
                     }
                     System.out.print('\n');
                }
                System.out.println("====================================================================");
                System.out.println("Please choose an action\r\n" + 
                        "1- Set a polynomial variable, ... etc\r\n" + 
                        "====================================================================");
                num_of_operation=scan.nextInt();
            }
            
        }
    }
    

}