class MoveZeroes{

static void MoveZeroes(int[] a)
{

    int lastZeroAt = 0;

    for(int i=0;i<a.length;i++)
    {
        if(a[i]!=0)
        {
            a[lastZeroAt++] = a[i];
        }
    }

    for(int i=lastZeroAt;i<a.length;i++)
    {
        a[i] = 0;
    }

    
}

public static void main(String[] args) {
    
int[] a = {0,1,2,0,1,0,0};

MoveZeroes(a);

for(int i:a){
    System.out.println(i);
}

}


}