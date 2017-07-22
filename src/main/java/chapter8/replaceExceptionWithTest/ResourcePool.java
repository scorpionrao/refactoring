package chapter8.replaceExceptionWithTest;

import java.util.EmptyStackException;
import java.util.Stack;

public class ResourcePool {

    Stack<Resource> _available;
    Stack<Resource> _allocated;

    ResourcePool(Stack<Resource> available, Stack<Resource> allocated) {
        this._available = available;
        this._allocated = allocated;
    }

    public Stack<Resource> getAvailable() {
        return _available;
    }

    public Stack<Resource> getAllocated() {
        return _allocated;
    }

    Resource getResourceWithException() {
        Resource result;
        try {
            result = _available.pop();
            _allocated.push(result);
            return result;
        } catch (EmptyStackException e) {
            result = new Resource();
            _allocated.push(result);
            return result;
        }
    }

    Resource getResourceWithoutException() {
        Resource result = null;
        try {
            if (_available.isEmpty()) {
                result = new Resource();
                _allocated.push(result);
            } else {
                result = _available.pop();
                _allocated.push(result);
            }
        } catch (Exception e) {

        }
        return result;
    }

    public static void main(String[] args) {
        Stack<Resource> available = new Stack<Resource>();
        Stack<Resource> allocated = new Stack<Resource>();
        ResourcePool pool = new ResourcePool(available, allocated);
        for(int i = 0; i < 100; i++) {
            pool.getResourceWithException();
            System.out.println("Loop - " + i);
            System.out.println("Available Stack size - " + pool.getAvailable().size());
            System.out.println("Allocated Stack size - " + pool.getAllocated().size());
        }
    }
}
