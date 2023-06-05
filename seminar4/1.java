class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.color = "red"

class TreeNode():

    COLOR_BLACK = "black"
    COLOR_RED = "red"
    

    def __init__(self):
        self.root = None

    def Red_and_zero(self, my_node):
        //Проверка ненулевого значения и цвета
        
        return my_node != None and my_node.color == TreeNode.COLOR_RED

    def RIGHT(self, my_node):
        //Левое вращение к правой части дерева
        child = my_node.left
        child_right = child.right
        child.right = my_node
        my_node.left = child_right
        return child

    def LEFT(self, my_node):
        //Правое вращение к левой части дерева
        child = my_node.right
        child_left = child.left
        child.left = my_node
        my_node.right = child_left
        return child

    def insert(self, data):
        //Вставка ноды
        node = None
        if self.root:
            node = self.BALANCE(self.root, data)
            if not node:
                return False
        else:
            node = Node(data)
        self.root = node
        self.root.color = TreeNode.COLOR_BLACK
        return True
    
    def COLOR(self, node1, node2):
        //Изменение цвета
        a = node1.color
        node1.color = node2.color
        node2.color = a

    

    def BALANCE(self, my_node, data):
        //Баланс дерева
        if my_node == None:
            return Node(data)
        if my_node.data > data:
            my_node.left = self.BALANCE(my_node.left, data)
        elif my_node.data < data:
            my_node.right = self.BALANCE(my_node.right, data)
        else:
            return None
        return self.balanced(my_node)

    def balanced(self, my_node):
        //Проверка указателя
        if self.Red_and_zero(my_node.right) and not self.Red_and_zero(my_node.left):
            my_node = self.LEFT(my_node)
            self.swap_colors(my_node, my_node.left)
        if self.Red_and_zero(my_node.left) and self.Red_and_zero(my_node.left.left):
            my_node = self.RIGHT(my_node)
            self.swap_colors(my_node, my_node.right)
        if self.Red_and_zero(my_node.left) and self.Red_and_zero(my_node.right):
            my_node.color = TreeNode.COLOR_RED
            my_node.left.color = TreeNode.COLOR_BLACK
            my_node.right.color = TreeNode.COLOR_BLACK
        return my_node

    def DRAW(self,node, offset=0):
        //Отображение дерева
        if node is not None:
            self.DRAW(node.right, offset + 4)
            print(' ' * offset + str(node.data) + ' (' + node.color + ')')
            self.DRAW(node.left, offset + 4)

if __name__ == "__main__":
     node = TreeNode()
     print("-----------------------")
     node.insert(10)
     node.DRAW(node.root)
     print("-----------------------")
     node.insert(30)
     node.DRAW(node.root)
     print("-----------------------")
     node.insert(20)
     node.DRAW(node.root)
     print("-----------------------")
     node.insert(-20)
     node.DRAW(node.root)
     print("-----------------------")
     node.insert(-10)
     node.DRAW(node.root)
     print("-----------------------")
     node.insert(-30)
     node.DRAW(node.root)
     print("-----------------------")
     node.insert(-40)
     node.DRAW(node.root)
     print("-----------------------")
     node.insert(-50)
     node.DRAW(node.root)
     print("-----------------------")
     node.insert(60)
     node.DRAW(node.root)
     print("-----------------------")
     node.insert(40)
     node.DRAW(node.root)
