package com.zyy.blog.commons.utils;


import com.zyy.blog.modules.sys.vo.Tree;


import java.util.ArrayList;
import java.util.List;

public class BuildTree {

    public static <T> Tree<T> build(List<Tree<T>> nodes){
        if(nodes==null){
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<Tree<T>>();
        for(Tree<T> children : nodes){
            Integer pid=children.getParentId();

            if(pid==null || "".equals(pid) || ("0").equals(pid)){
                topNodes.add(children);
                continue;
            }
            for (Tree<T> parent:nodes){
                Integer id=parent.getId();

                if(id!=null && id.equals(pid)){
                    parent.getChildren().add(children);
                    continue;
                }
            }
        }

        Tree<T> root = new Tree<T>();
        if(topNodes.size() == 1){
            root=topNodes.get(0);

        }else{
            root.setChildren(topNodes);
        }
        return root;
    }
}

