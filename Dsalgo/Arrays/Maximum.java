class Maximum{

public static void main(String[] args)
{
int[] res = {2,3,4};

int max = Integer.MIN_VALUE;
int min =Integer.MAX_VALUE;
for(int i=0;i<res.length;i++)
{
if(res[i]>max)
{
    max = res[i];
}
else if(res[i]<min)
{
    min = res[i];
}

}

System.out.println(max);
System.out.


}
}