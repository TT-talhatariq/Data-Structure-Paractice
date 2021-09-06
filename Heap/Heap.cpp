#include<iostream>
using namespace std;
class Heap{
	private:
		int *heap;
		int cap;
		int size;
	public:
		Heap(){
			cap = 1000;
			heap = new int[cap];
			size = 0;
		}	
		Heap(int n){
			cap = n;
			heap = new int[cap];
			size = 0;
		}	
		int parent(int i){
			return (i-1)/2;
		}
		int left(int i){
			return (2*i)+1;
		}
		int right(int i){
			return (2*i)+2;
		}
		void swap(int& a, int& b){
			int tmp = a;
			a = b;
			b = tmp;
		}
		void insert(int val){
			size++;
			int i;
			i = size-1;
			heap[i] = val;
			
			while( i!=0 && heap[parent(i)] > heap[i]){
				swap(heap[i], heap[parent(i)]);
				i = parent(i);
			}
			
		}
	
		void decreaseKey(int i, int val){
    		heap[i] = val;
    		while (i != 0 && heap[parent(i)] > heap[i]){
		       swap(heap[i], heap[parent(i)]);
       		   i = parent(i);
	   		}
		}
		
		int extract(){
			if(size==0){
				return INT_MAX;		
			}
			if(size == 1){
				size--;
				return heap[0];
			}
			
			
			
		}
		// This method assumes that the subtrees are already heapified
void MinHeapify(int i)
{
    int l = left(i);
    int r = right(i);
    int smallest = i;
    if (l < size && heap[l] < heap[i])
        smallest = l;
    if (r < size && heap[r] < heap[smallest])
        smallest = r;
    if (smallest != i)
    {
        swap(heap[i], heap[smallest]);
        MinHeapify(smallest);
    }
}
		void display(){
			for(int i=0; i<size; i++){
				cout << heap[i] << " ";
			}
		}
		
		
};

int main(){
	Heap heap;
	heap.insert(5);
	heap.insert(10);
	heap.insert(4);
	heap.insert(3);
	heap.insert(2);
	heap.insert(1);
	heap.display();
	cout << endl;
	heap.MinHeapify(2);
	heap.display();
	return 0;
}
