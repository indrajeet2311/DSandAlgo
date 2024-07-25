class RemoveDuplicate{

static int removeDuplicate(int[] a)
{
int uniqueIndex =1;

for(int i=1;i<a.length;i++)
{
if(a[i]!=a[i-1])
{
    a[uniqueIndex] = a[i];
    uniqueIndex++;
}
}
return uniqueIndex;

}


public static void main(String[] args) {
    
int[] a = {1,2,2,4,5};

System.out.println(removeDuplicate(a));

}


}