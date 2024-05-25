class DynamicArray:
    def __init__(self, resize_factor=2.0):
        self.capacity = 10
        self.array = [0] * self.capacity
        self.size = 0
        self.resize_factor = resize_factor

    def insert(self, index, element):
        if index < 0 or index > self.size:
            raise IndexError("Index out of bounds")
        if self.size == self.capacity:
            self.resize()
        self.array[index + 1:self.size + 1] = self.array[index:self.size]
        self.array[index] = element
        self.size += 1

    def delete(self, index):
        if index < 0 or index >= self.size:
            raise IndexError("Index out of bounds")
        self.array[index:self.size - 1] = self.array[index + 1:self.size]
        self.size -= 1

    def get_size(self):
        return self.size

    def is_empty(self):
        return self.size == 0

    def rotate(self, k):
        k = k % self.size
        self.reverse(0, self.size - 1)
        self.reverse(0, k - 1)
        self.reverse(k, self.size - 1)

    def reverse(self, start=0, end=None):
        if end is None:
            end = self.size - 1
        while start < end:
            self.array[start], self.array[end] = self.array[end], self.array[start]
            start += 1
            end -= 1

    def append(self, element):
        if self.size == self.capacity:
            self.resize()
        self.array[self.size] = element
        self.size += 1

    def prepend(self, element):
        self.insert(0, element)

    def merge(self, other):
        while self.size + other.size > self.capacity:
            self.resize()
        self.array[self.size:self.size + other.size] = other.array[:other.size]
        self.size += other.size

    @staticmethod
    def interleave(a, b):
        result = DynamicArray()
        i = j = 0
        while i < a.size or j < b.size:
            if i < a.size:
                result.append(a.array[i])
                i += 1
            if j < b.size:
                result.append(b.array[j])
                j += 1
        return result

    def middle(self):
        if self.size == 0:
            raise Exception("Array is empty")
        return self.array[self.size // 2]

    def index_of(self, element):
        for i in range(self.size):
            if self.array[i] == element:
                return i
        return -1

    def split(self, index):
        if index < 0 or index > self.size:
            raise IndexError("Index out of bounds")
        left = DynamicArray()
        right = DynamicArray()

        for i in range(index):
            left.append(self.array[i])
        for i in range(index, self.size):
            right.append(self.array[i])
        return left, right

    def resize(self):
        self.capacity = int(self.capacity * self.resize_factor)
        self.array = self.array[:self.size] + [0] * (self.capacity - self.size)

    def __str__(self):
        return str(self.array[:self.size])

# Example usage
if __name__ == "__main__":
    arr = DynamicArray()

    arr.append(1)
    arr.append(2)
    arr.append(3)

    arr.insert(1, 5)

    print("Array size:", arr.get_size())
    print("Is array empty?", arr.is_empty())
    arr.rotate(1)
    print("After rotating:", arr)

    arr.reverse()
    print("After reversing:", arr)

    arr.prepend(0)
    print("After prepending:", arr)
    arr2 = DynamicArray()
    arr2.append(6)
    arr2.append(7)

    arr.merge(arr2)
    print("After merging:", arr)

    interleaved = DynamicArray.interleave(arr, arr2)
    print("Interleaved array:", interleaved)

    print("Middle element:", arr.middle())

    print("Index of element 5:", arr.index_of(5))

    split_arrays = arr.split(3)
    print("Left split array:", split_arrays[0])
    print("Right split array:", split_arrays[1])
