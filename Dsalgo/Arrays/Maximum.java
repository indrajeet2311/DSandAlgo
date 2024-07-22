class Maximum{

public static void main(String[] args)
{
int[] res = {2,3,4};

int max = Integer.MIN_VALUE;

for(int i=0;i<res.length;i++)
{
if(res[i]>max)
{
    max = res[i];
}
}

System.out.println(max);



}
}