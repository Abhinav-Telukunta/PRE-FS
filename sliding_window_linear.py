'''given an array of numbers and a number k find maximum element for first k elements and then second k elements
and so on in O(n) time'''
#if array is 5 4 3 2 1 and k=3
#then maximum element for first 3 numbers is 5=max(5,4,3)
#maximum element for second 3 numbers is 4=max(4,3,2)
#maximum element for third 3 numbers is 3=max(3,2,1)
#so ans is 5 4 3
n,k=map(int,input().split())
arr=deque([int(x) for x in input().split()])
r=deque([])
q=deque([])
for i in range(n):
    while len(q)!=0 and q[0]<i-k+1:
        q.popleft()
    while len(q)!=0 and arr[q[-1]]<arr[i]:
        q.pop()
    q.append(i)
    if i>=k-1:
        r.append(arr[q[0]])
print(*r)

        


    
