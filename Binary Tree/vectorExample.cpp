#include<iostream>
#include<vector>

using namespace std;

template <class T>
void printVector(vector<T> v) {
    for (vector<T>::iterator i=v.begin(); i<v.begin()+v.size(); i++) 
        cout << " " << *i << " ";
    cout << endl;
}

int main () {

    vector<int> v1; // default constructor, creates an empty vector

    vector<int> v2(4); // vector of size 4 
    
    vector<int> v3(5, 12); // vector containing five 12s

    vector<int> v4(v3); // copy constructor

    vector<int>::iterator i1=v4.begin();
    vector<int> v5(i1, i1+2); // vector containing elements from *i1 to *(i1+1)

    for (int j=0; j<6; j++) 
        v1.push_back(j);

    printVector(vector<int>(v1.begin(), v1.begin()+3));
   
    cout << v1.front() << endl << v1.back() << endl << v1.at(4) << endl << v1[4] << endl;
    v1[148] = 2;

    v2.insert(v2.begin(), 23);
    v2.insert(v2.end(), v1[2]);
    v2.insert(v2.end(), 4, 39);
    v2.insert(v2.end(), v1.begin()+1, v1.begin()+3);

    v3.resize(8, 20);
    v3.resize(10);
    v3.resize(3);
    v3.reserve(6);

    v4.assign(v1.begin(), v1.end()-1);
    v4.pop_back();
    v4.erase(v4.begin(), v4.end()-1);
    v4.erase(v4.begin());
    if (v4.empty()) cout << "Empty!\n";

    cout << v5.capacity() << endl << v5.size() << endl; 
    v5.clear();
    
    int a[5]={10,20,30,40,50};
    v5.assign(a, a+4);
    v1.assign(a, a+3);

    if (v1<=v5) 
       cout << "v1<=v5";

    v1.swap(v5);

    vector<int>(v3).swap(v3);

    return 0;
}
