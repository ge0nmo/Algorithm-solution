package tree;

import java.util.*;

public class TraversalBFS
{
    Node root;

    public void BFS(Node root)
    {
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;

        while(!que.isEmpty())
        {
            int length = que.size();
            System.out.print(length + "= ");

            for(int i = 0; i < length; i++)
            {
                Node cur = que.poll();
                System.out.print(cur.data + " ");

                if(cur.lt != null)
                    que.offer(cur.lt);

                if(cur.rt != null)
                    que.offer(cur.rt);

            }
            depth++;
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        TraversalBFS tree = new TraversalBFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
