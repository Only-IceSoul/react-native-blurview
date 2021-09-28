import React from 'react'
import {  StyleSheet } from 'react-native'




const BlurRootView = (props)=>{

    const {name,style,...others} = props

    const styleObject = typeof style === 'number' ? StyleSheet.flatten(style) : style

    return(
        <div {...others} style={styleObject} >
        </div>
    )
}

export default BlurRootView