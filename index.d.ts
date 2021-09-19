import React from "react";
import { Constructor, NativeMethods, ViewProps } from "react-native";

interface BlurRootProps extends ViewProps {
    name?:string
}

interface BlurProps extends ViewProps {
    blurNode?:string
}

declare class BlurRootComponent extends React.Component<BlurRootProps> {}
declare const BlurRootViewBase: Constructor<NativeMethods> & typeof BlurRootComponent;

declare class BlurComponent extends React.Component<BlurProps> {}
declare const BlurViewBase: Constructor<NativeMethods> & typeof BlurComponent;

export class BlurView extends BlurViewBase {}
export class BlurRootView extends BlurRootViewBase {}