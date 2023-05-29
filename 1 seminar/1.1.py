def LEFT(i):
    return 2*i + 1
 
def RIGHT(i):
    return 2*i + 2
def swap(A, i, j):
 
    temp = A[i]
    A[i] = A[j]
    A[j] = temp
 
 
# Рекурсивный алгоритм heapify-down. 
def heapify(A, i, size):
 
    
    left = LEFT(i)
    right = RIGHT(i)
 
    largest = i
 
    
    if left < size and A[left] > A[i]:
        largest = left
 
    if right < size and A[right] > A[largest]:
        largest = right
 
    
    if largest != i:
        swap(A, i, largest)
        heapify(A, largest, size)
 
 
# Функция удаления элемента с наивысшим приоритетом 
def pop(A, size):
 
    #, если в куче нет элементов
    if size <= 0:
        return -1
 
    top = A[0]
 
    # заменить корень кучи последним элементом
    # списка
    A[0] = A[size - 1]
 
    # вызывает heapify-down на корневом узле
    heapify(A, 0, size - 1)
 
    return top
 
 
# Функция для выполнения пирамидальной сортировки в списке `A` размера `n`
def heapsort(A):
 
    # создает приоритетную очередь и инициализирует ее заданным списком
    n = len(A)
 
  
    i = (n - 2) // 2
    while i >= 0:
        heapify(A, i, n)
        i = i - 1
 
    # постоянно выталкивается из кучи, пока она не станет пустой
    while n:
        A[n - 1] = pop(A, n)
        n = n - 1
 
 
if __name__ == '__main__':
 
    A = [3, 5, 5, 6, 7, -8]
 
    # выполняет пирамидальную сортировку списка
    heapsort(A)
 

    print(A)
 
