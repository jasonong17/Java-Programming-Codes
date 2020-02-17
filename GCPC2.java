import java.util.*;
import java.lang.*;
import java.io.*;

class GCPC2 {
    public static void main(String[] args) {
        Kattix io = new Kattix(System.in, System.out);

        int teams = io.getInt();
        int events = io.getInt();
        Team[] teamsArr = new Team[teams];
        //Team[] prevResult = new Team[teams];
        AVL avl = new AVL();

        for(int i = 0; i < teams; i++) {
            teamsArr[i] = new Team(i+1);
            //prevResult[i] = new Team(i+1);
        }

        for(int i = 0; i < teams; i++) {
            AVLVertex vertex = new AVLVertex(teamsArr[i]);
            avl.insert(vertex);
        }

        for(int i = 0; i < events; i++) {
            /*int winner = io.getInt();
            int penalty = io.getInt();

            teamsArr[winner-1].setWins(teamsArr[winner-1].getWins() + 1);
            teamsArr[winner-1].setPenalty(teamsArr[winner-1].getPenalty() + penalty);
            AVLVertex newVertex = new AVLVertex(teamsArr[winner-1]);
            AVLVertex oldVertex = new AVLVertex(prevResult[winner-1]);

            if(avl.search(oldVertex) != null) {
                avl.delete(oldVertex);
            }

            avl.insert(newVertex);

            prevResult[winner-1] = teamsArr[winner-1];
            AVLVertex findVertex = new AVLVertex(prevResult[0]);
            avl.inorder();
            io.println(avl.rank(findVertex));*/

            int winner = io.getInt();
            int penalty = io.getInt();

            AVLVertex oldVertex = new AVLVertex(teamsArr[winner-1]);
            avl.delete(oldVertex);

            teamsArr[winner-1].setWins(teamsArr[winner-1].getWins() + 1);
            teamsArr[winner-1].setPenalty(teamsArr[winner-1].getPenalty() + penalty);

            AVLVertex newVertex = new AVLVertex(teamsArr[winner-1]);
            avl.insert(newVertex);

            AVLVertex findVertex = new AVLVertex(teamsArr[0]);
            io.println(avl.rank(findVertex));
      //System.out.println(avl.root.team.getTeamNum());
        }
        io.close();
    }
}

class Team implements Comparable<Team>{
    public int wins = 0;
    public int penalty = 0;
    public int teamNum = 0;

    public Team(int teamNum) {
        this.teamNum = teamNum;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getWins() {
        return wins;
    }

    public int getPenalty() {
        return penalty;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public int compareTo(Team v) {
        if(this.getWins() < v.getWins()) {
            return -1;
        }
        else if(this.getWins() > v.getWins()) {
            return 1;
        }
        else {
            if(this.getPenalty() < v.getPenalty()) {
                return 1;
            }
            else if(this.getPenalty() > v.getPenalty()) {
                return -1;
            }
            else {
                if(this.getTeamNum() > v.getTeamNum()) {
                    return -1;
                }
                else if(this.getTeamNum() < v.getTeamNum()){
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
    }
}

/* This is just a rough idea of how to transform the BSTDemo.java under your lect10_programs
 * So you can and should reference that while doing your AVL tree
 * The difference is that instead of the input is an int (the only attribute in the BSTVertex)
 * the input will be a AVLVertex itself
 *
 * The AVL code uses a lot of recursion and overloading
 *
 * There are other ways to implement an AVLTree, for example some might prefer to just make a generic AVLNode and have another class
 * as the attribute 'key' and just compare the .key for ordering. That works too and it would follow more closely to the BSTDemo.java
 * where you can literally copy and have 99% of your code done. 
 *
 * The code might have some minor errors as I did not try to compile it, so make any changes you need
*/

class AVLVertex implements Comparable<AVLVertex>{
  public AVLVertex parent, left, right;
  public int key;
  public Team team;
  public int height;
  public int size;

  AVLVertex(Team team) {
     this.team = team;
     parent = left = right = null;
     height = 0;
     size = 1; // This wasn't included in the BSTVertex but is required here
   }

   public int compareTo(AVLVertex v) {
     return this.team.compareTo(v.team);
   } // As you need an ordering for your vertices, it is easier to implement here rather than create a new comparable class
}

class AVL {
  /* Every action that is performed starts from the root
   * So try to visualize how you would take the action
   * It could help your implementation
   */
  public AVLVertex root;

  public AVL() { 
    root = null;
  }

  // Searching is just going left/right till you find the right node
  public AVLVertex search(AVLVertex v) {
    AVLVertex res = search(root, v);
    return res == null ? null : res;
  }

  public AVLVertex search(AVLVertex T, AVLVertex v) {
         if (T == null)           return null;
    else if (T.compareTo(v) == 0) return T;
    else if (T.compareTo(v) < 0)  return search(T.left, v);
    else                          return search(T.right, v);
  }

  // Finding the min and max is just going left or right all the way
  public AVLVertex findMin() { 
    return findMin(root); 
  }

  public AVLVertex findMin(AVLVertex T) {
    if (T.left == null) return T;
    else                return findMin(T.left);
  }

  public AVLVertex findMax() {
    return findMax(root);
  }

  public AVLVertex findMax(AVLVertex T) {
    if (T.right == null) return T;
    else                 return findMax(T.right);  
  }

  /* The successor of a node is simply the immediate next larger node
   * The successor would be the minimum in the subtree of the right child if there is a right children
   * Otherwise go up the parent till the first right turn
   */
   //public AVLVertex successor(AVLVertex v) {
     //AVLVertex vPos = search(root, v);
     //return vPos == null ? null : successor(vPos);
   //}

   public AVLVertex successor(AVLVertex T) {
     if (T.right != null)                       // this subtree has right subtree
       return findMin(T.right);  // the successor is the minimum of right subtree
     else {
       AVLVertex par = T.parent;
       AVLVertex cur = T;
       // if par(ent) is not root and cur(rent) is its right children
       while ((par != null) && (cur == par.right)) {
         cur = par;                                         // continue moving up
         par = cur.parent;
       }
       return par == null ? null : par;           // this is the successor of T
     }
   }

   /* The predecessor of a node is just the immediate next smaller node
    * The implementation is just the opposite of successor
    * You can pass the THL without this function but it would be a good practice to implement it
   */
   //public AVLVertex predecessor(AVLVertex V) {
     //AVLVertex vPos = search(root, v);
     //return vPos == null ? null : predecessor(vPos);
   //}

   public AVLVertex predecessor(AVLVertex T) {
     if (T.left != null)                         // this subtree has left subtree
       return findMax(T.left);  // the predecessor is the maximum of left subtree
     else {
       AVLVertex par = T.parent;
       AVLVertex cur = T;
       // if par(ent) is not root and cur(rent) is its left children
       while ((par != null) && (cur == par.left)) { 
         cur = par;                                         // continue moving up
         par = cur.parent;
       }
       return par == null ? null : par;           // this is the successor of T
     }
   }

   // Inorder traversal is just one of the three tree traversals
   // Use it to check the implementation of your AVL
   public void inorder() {//left, print, right}
     inorder(root);
     System.out.println();
   }

   public void inorder(AVLVertex T) {
     if(T == null) return;
     inorder(T.left);
     System.out.printf(" %d", T.team.getTeamNum());
     inorder(T.right);
   }                                               

   /* To insert a node, just traverse down a tree till you find a suitable spot to insertion
    * Since this is a AVL, you will have to update your height and size and then balance
    */
   public void insert(AVLVertex V) {
     root = insert(root,V);
   }

   public AVLVertex insert(AVLVertex T, AVLVertex v) {
     if (T == null) return v;          // insertion point is found

     if (T.compareTo(v) > 0) { //search left
       T.right = insert(T.right, v);
       T.right.parent = T;
     }
     else { //search right
       T.left = insert(T.left, v);
       T.left.parent = T;
     }

     // Update height and size
     // T.size = ?
     T.size = 1 + size(T.left) + size(T.right);
     // T.height = ?
     T.height = 1 + Math.max(height(T.left), height(T.right));

     return balance(T);
   }

   /* The reason why we need the following 2 functions is because you can't simply call
    * leftChild.size or leftchild.height as it is not guaranteed that the node will always
    * have a left or right child. When that happens you will run into nullpointerexception
    */
   public int size(AVLVertex V) {
     if (V == null) {return 0;}
     return V.size;
   }

   public int height(AVLVertex V) {
     if (V == null) {return -1;}
     return V.height;
   }

   /* To delete a node we have to first search down the tree then replace it with
    * its successor or predecessor. The difference here is that instead of just changing
    * the attribute value like in the BSTDemo, it is fully replaced here
    */
    public void delete(AVLVertex v) {
      root = delete(root, v);
    }

    // helper recursive method to perform deletion
    public AVLVertex delete(AVLVertex T, AVLVertex v) {
      if (T == null) {
        return T;
      }              // cannot find the item to be deleted

      if (T.compareTo(v) < 0)                                    // search to the right
        T.left = delete(T.left, v);
      else if (T.compareTo(v) > 0)                               // search to the left
        T.right = delete(T.right, v);
      else {                                            // this is the node to be deleted
        if (T.left == null && T.right == null)                   // this is a leaf
          return null;                                      // simply erase this node
        else if (T.left == null && T.right != null) {   // only one child at right
          T.right.parent = T.parent;
          return T.right;                                                 // bypass T
        }
        else if (T.left != null && T.right == null) {    // only one child at left
          T.left.parent = T.parent;
          return  T.left;                                                  // bypass T
        }
        else {                                 // has two children, find successor
          AVLVertex temp = T;
          T = successor(T);
          T.right = delete(T.right,T);
          T.left = temp.left;
        }
      }

      // Update height and size
      // T.size = ?
      T.size = 1 + size(T.left) + size(T.right);
      // T.height = ?
      T.height = 1 + Math.max(height(T.left), height(T.right));

      return balance(T);                                          // return the updated BST
    }

    /* To balance a (portion of) tree, you need to check the height difference of the
     * 2 child and from there determine if you need a L, LR, R or RL rotations.
     * Check the conditions in your notes and familiarise yourself with it.
     * It's also good to write a function to calculate the balance factor instead
     * of writing it 4 long if-conditions
     */
    public AVLVertex balance(AVLVertex T) {
      if (balFac(T) > 1) {
        if (balFac(T.left) < 0) {
          // rotateLeft T.left
          T.left = rotateLeft(T.left);
        }
        T = rotateRight(T);
        // rotateRight T
      }

      if (balFac(T) < -1) {
        if (balFac(T) > 0) {
          // rotateRight T.right
          T.right = rotateRight(T.right);
        }
        T = rotateLeft(T);
        // rotateLeft T
      }

      return T;
    }

    public int balFac(AVLVertex T) {
        return height(T.left) - height(T.right);
    }

    // Rotate left and right are available in your notes
    public AVLVertex rotateRight(AVLVertex T) {
        AVLVertex w = T.left;
        w.parent = T.parent;
        T.parent = w;
        T.left = w.right;
        if(w.right != null) {
            w.right.parent = T;
        }
        w.right = T;

        w.size = T.size;
        T.size = 1 + size(T.left) + size(T.right);

        w.height = 1 + Math.max(height(w.left), height(w.right));
        T.height = 1 + Math.max(height(T.left), height(T.right));

        return w;
    }

    public AVLVertex rotateLeft(AVLVertex T) {
        AVLVertex w = T.right;
        w.parent = T.parent;
        T.parent = w;
        T.right = w.left;
        if (w.left != null) {
            w.left.parent = T;
        }
        w.left = T;

        w.size = T.size;
        T.size = 1 + size(T.left) + size(T.right);

        w.height = 1 + Math.max(height(w.left), height(w.right));
        T.height = 1 + Math.max(height(T.left), height(T.right));

        return w;
    }

    // Rank will be needed for this THL
    public int rank(AVLVertex V) {
      return rank(root,V);
    }

    public int rank(AVLVertex T, AVLVertex V){
      /*if (T == null) { //If the vertex isn't in the tree
        return -1;
      }
      if (T.compareTo(V) == 0) {
        return size(T.left) + 1;
      }
      else if (T.compareTo(V) < 0) {
        return rank(T.left, V);
      }
      else {
        return size(T.left) + 1 + rank(T.right, V);
      }*/
      // if T > S, just go left
      // if T < S, go right and add 1 + size(T.left) to rank
      // if T == S, return size(T.left) + 1
      int i = 1;
      while (T != null) {
          //System.out.println(T.team.teamNum + " vs " + V.team.teamNum + " "+ T.compareTo(V));
        // Go left
        if (T.compareTo(V) > 0) {
            
            i += 1 + size(T.left);
            T = T.right;
        }
        // Go right
        else if (T.compareTo(V) < 0) {
            T = T.left;
        }
        // Endpoint
        else {//System.out.println("goleft: "+size(T.left));
            return i + size(T.left);       
        }
      }
    return i;
    }
}

class Kattix extends PrintWriter {
    public Kattix(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattix(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}