import React, { useMemo } from 'react'
import {  StyleSheet } from 'react-native'




const BlurRootView = (props)=>{

    const {name,style,...others} = props

    const styleObject = useMemo(()=>{
        if (typeof style === 'number') return StyleSheet.flatten(style) 
        if(Array.isArray(style)){
           var styleJs = {}
           style.forEach((v)=>{
             if(typeof v === 'number'){
                let ss = StyleSheet.flatten(style) 
                Object.assign(styleJs,ss)
             }else{
               Object.assign(styleJs,v)
             }
           })
 
           return styleJs
        }
        return style
    },[style])

    return(
        <div {...others} style={styleObject} >
        </div>
    )
}

export default BlurRootView