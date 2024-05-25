class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.size = 0

    def insert(self, index, data):
        if index < 0 or index > self.size:
            raise IndexError("Index out of bounds")
        new_node = Node(data)
        if index == 0:
            new_node.next = self.head
            self.head = new_node
        else:
            current = self.head
            for _ in range(index - 1):
                current = current.next
            new_node.next = current.next
            current.next = new_node
        self.size += 1

    def delete(self, index):
        if index < 0 or index >= self.size:
            raise IndexError("Index out of bounds")
        if index == 0:
            self.head = self.head.next
        else:
            current = self.head
            for _ in range(index - 1):
                current = current.next
            current.next = current.next.next
        self.size -= 1

    def get_size(self):
        return self.size

    def is_empty(self):
        return self.size == 0

    def rotate_right(self, k):
        if self.size == 0 or k <= 0:
            return
        k = k % self.size
        if k == 0:
            return
        
        old_tail = self.head
        length = 1
        while old_tail.next:
            old_tail = old_tail.next
            length += 1
        old_tail.next = self.head

        new_tail = self.head
        for _ in range(length - k - 1):
            new_tail = new_tail.next
        self.head = new_tail.next
        new_tail.next = None

    def reverse(self):
        prev = None
        current = self.head
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        self.head = prev

    def append(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = new_node
        self.size += 1

    def prepend(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node
        self.size += 1

    def merge(self, other_list):
        if not other_list.head:
            return
        if not self.head:
            self.head = other_list.head
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = other_list.head
        self.size += other_list.size

    def interleave(self, other_list):
        current1 = self.head
        current2 = other_list.head
        while current1 and current2:
            next1 = current1.next
            next2 = current2.next

            current1.next = current2
            if not next1:
                break
            current2.next = next1

            current1 = next1
            current2 = next2
        self.size += other_list.size

    def get_middle(self):
        if not self.head:
            raise Exception("List is empty")
        slow = self.head
        fast = self.head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow.data

    def index_of(self, data):
        current = self.head
        index = 0
        while current:
            if current.data == data:
                return index
            current = current.next
            index += 1
        return -1

    def split(self, index):
        if index < 0 or index > self.size:
            raise IndexError("Index out of bounds")
        list1 = SinglyLinkedList()
        list2 = SinglyLinkedList()

        current = self.head
        for _ in range(index):
            list1.append(current.data)
            current = current.next
        while current:
            list2.append(current.data)
            current = current.next
        return [list1, list2]

    def print_list(self):
        current = self.head
        while current:
            print(current.data, end=" ")
            current = current.next
        print()

# Test the implemented methods
if __name__ == "__main__":
    list = SinglyLinkedList()

    # Test the implemented methods
    list.append(1)
    list.append(2)
    list.append(3)
    list.print_list()

    list.insert(1, 4)
    list.print_list()

    list.delete(2)
    list.print_list()

    print("Size:", list.get_size())
    print("Is empty:", list.is_empty())

    list.rotate_right(1)
    list.print_list()

    list.reverse()
    list.print_list()

    list.prepend(0)
    list.print_list()

    list2 = SinglyLinkedList()
    list2.append(5)
    list2.append(6)

    list.merge(list2)
    list.print_list()

    list2.append(7)
    list2.append(8)
    list2.append(9)
    list.interleave(list2)
    list.print_list()

    print("Middle element:", list.get_middle())

    print("Index of 5:", list.index_of(5))

    split_lists = list.split(4)
    split_lists[0].print_list()
    split_lists[1].print_list()
