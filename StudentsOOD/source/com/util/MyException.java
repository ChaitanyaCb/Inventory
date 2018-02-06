package com.util;
import java.io.*;
import java.util.*;

class MyException extends Exception
{
  String str;
  public MyException(String s)
  {
    str = s;
  }
  public String toString()
  {
    return ("MyException occured:"+str);
  }
}
