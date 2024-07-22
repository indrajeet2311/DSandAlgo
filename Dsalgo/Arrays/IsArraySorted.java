class IsArraySorted{

static boolean IsArraySorted(int[] a)
{
    for(int i=a.length-1;i>=0;i--)
    {
    if(a[i]> a[i+1])
    {
        return false;
    }
    }
    return true;
}

public static void main(String[] args) {
    
int[] a = {1,2,3};
System.out.println(IsArraySorted(a));


}

}