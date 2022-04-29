package com.bear.testtdd

class RegisterVerify {
    /**
     *
     * @param account String
     * @return Boolean
     * 建立
     */
    fun checkAccount(account:String):Boolean{
        var result=false
        //若帳號長度大於等於6且第一個字是英文
        if(account.length>=6) {
            if (account.uppercase().first() in 'A'..'Z') {
                result =true
            }
        }
        return result
    }
}