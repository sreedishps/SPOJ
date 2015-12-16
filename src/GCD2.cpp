#include<iostream>
using namespace std;

long specialMode(string big,long small){
    if(small == 0){
        return 0;
    }
    long remainder = 0;
    for (int index = 0; index < big.length(); index++){
        if(remainder >= small){
            remainder = remainder % small;
        }
            remainder = remainder * 10;
            remainder +=  (big[index] - '0');
        
    }
    return remainder % small;
}

long gcd(long A,long B){
    if(B == 0 ){
        return A;
    }
    return gcd(B,A % B);
}

int main(){
long n;
cin>>n;
while(n-- > 0){
long small;
cin >> small;
string big;
cin>>big;

if(small == 0){
    cout<<big<<"\n";
    continue;
}

long big_made_small = specialMode(big,small);
cout<< gcd(small , big_made_small)<<"\n";
}

return 0;
}
